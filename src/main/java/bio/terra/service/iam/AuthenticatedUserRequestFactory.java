package bio.terra.service.iam;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticatedUserRequestFactory {

    AuthenticatedUserRequest from(HttpServletRequest servletRequest);

}
