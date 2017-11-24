/*
 * SonarQube
 * Copyright (C) 2009-2017 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonarqube.ws.client.projectbranches;

import javax.annotation.Generated;
import org.sonarqube.ws.MediaTypes;
import org.sonarqube.ws.client.BaseService;
import org.sonarqube.ws.client.GetRequest;
import org.sonarqube.ws.client.PostRequest;
import org.sonarqube.ws.client.WsConnector;
import org.sonarqube.ws.ProjectBranches.ListWsResponse;

/**
 * Manage branch (only available when the Branch plugin is installed)
 * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/project_branches">Further information about this web service online</a>
 */
@Generated("sonar-ws-generator")
public class ProjectBranchesService extends BaseService {

  public ProjectBranchesService(WsConnector wsConnector) {
    super(wsConnector, "api/project_branches");
  }

  /**
   * Delete a non-main branch of a project.<br/>Requires 'Administer' rights on the specified project.
   *
   * This is part of the internal API.
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/project_branches/delete">Further information about this action online (including a response example)</a>
   * @since 6.6
   */
  public String delete(DeleteRequest request) {
    return call(
      new PostRequest(path("delete"))
        .setParam("branch", request.getBranch())
        .setParam("project", request.getProject())
        .setMediaType(MediaTypes.JSON)
      ).content();
  }

  /**
   * List the branches of a project.<br/>Requires 'Administer' rights on the specified project.
   *
   * This is part of the internal API.
   * This is a GET request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/project_branches/list">Further information about this action online (including a response example)</a>
   * @since 6.6
   */
  public ListWsResponse list(ListRequest request) {
    return call(
      new GetRequest(path("list"))
        .setParam("project", request.getProject()),
      ListWsResponse.parser());
  }

  /**
   * Rename the main branch of a project.<br/>Requires 'Administer' permission on the specified project.
   *
   * This is part of the internal API.
   * This is a POST request.
   * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/project_branches/rename">Further information about this action online (including a response example)</a>
   * @since 6.6
   */
  public void rename(RenameRequest request) {
    call(
      new PostRequest(path("rename"))
        .setParam("name", request.getName())
        .setParam("project", request.getProject())
        .setMediaType(MediaTypes.JSON)
      ).content();
  }
}