package bio.terra.validation;

import bio.terra.model.DatasetRequestContentsModel;

import bio.terra.model.DatasetRequestModel;
import bio.terra.model.DatasetRequestSourceModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * This validator runs along with the constraint validation that comes from the Models generated by swagger-codegen.
 * The constraints will be able to handle things like nulls, but not things like uniqueness or other structural
 * validations.
 *
 * There are a lot of null checks here because this will still be called even if a constraint validation failed.
 * Spring will not shortcut out early if a validation fails, so this Validator will still get nulls and should only
 * validate if the field is present.
 */
@Component
public class DatasetRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }


    private void validateDatasetName(String datasetName, Errors errors) {
        if (datasetName == null) {
            errors.rejectValue("name", "DatasetNameMissing");
        } else if (!ValidationUtils.isValidName(datasetName)) {
            errors.rejectValue("name", "DatasetNameInvalid");
        }
    }

    private void validateDatasetValues(List<DatasetRequestContentsModel> contentsList, Errors errors) {
        if (contentsList == null || contentsList.isEmpty()) {
            errors.rejectValue("contents", "DatasetSourceListEmpty");
        } else {
            contentsList.forEach(contents -> {
                List<String> rootValues = contents.getRootValues();
                if (rootValues == null || rootValues.isEmpty()) {
                    errors.rejectValue("contents", "DatasetRootValuesListEmpty");
                }
                DatasetRequestSourceModel source = contents.getSource();
                String studyName = source.getStudyName();
                String assetName = source.getAssetName();
                if (studyName == null) {
                    errors.rejectValue("contents", "DatasetStudyNameMissing");
                } else if (!ValidationUtils.isValidName(studyName)) {
                    errors.rejectValue("contents", "DatasetStudyNameInvalid");
                }
                if (assetName == null) {
                    errors.rejectValue("contents", "DatasetAssetNameMissing");
                } else if (!ValidationUtils.isValidName(assetName)) {
                    errors.rejectValue("contents", "DatasetAssetNameInvalid");
                }
            });
        }
    }

    private void validateDatasetDescription(String description, Errors errors) {
        if (description == null) {
            errors.rejectValue("description", "DatasetDescriptionMissing");
        } else if (!ValidationUtils.isValidDescription(description)) {
            errors.rejectValue("description", "DatasetDescriptionTooLong");
        }
    }

    @Override
    public void validate(@NotNull Object target, Errors errors) {
        if (target != null && target instanceof DatasetRequestModel) {
            DatasetRequestModel datasetRequestModel = (DatasetRequestModel) target;
            validateDatasetName(datasetRequestModel.getName(), errors);
            validateDatasetDescription(datasetRequestModel.getDescription(), errors);
            validateDatasetValues(datasetRequestModel.getContents(), errors);
        }
    }
}
