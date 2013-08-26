/*
 * Copyright (C) 2012-2013 University of Washington
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.opendatakit.aggregate.odktables.api;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

/**
 * Servlet for downloading a manifest of files to the phone for the correct app
 * and the correct table.
 * @author sudar.sam@gmail.com
 *
 */
@Path("filemanifest")
public interface FileManifestService {
    
  /** URL parameter specifying the app. Always required. */
  public static final String PARAM_APP_ID = "app_id";
  /** 
   * URL parameter specifying the tableId. Optional. If not present, will 
   * return all the files for the application.
   */
  public static final String PARAM_TABLE_ID = "table_id";
  /**
   * URL parameter specifying whether or not only the app level files should be
   * returned. If present, this will override the tableId parameter.
   */
  public static final String PARAM_APP_LEVEL_FILES = "app_level_files";

  @GET
  public String getFileManifest(@Context ServletContext servletContext, 
      @Context HttpServletRequest req, @Context HttpServletResponse resp,
      @QueryParam (PARAM_APP_ID) String appId,
      @QueryParam (PARAM_TABLE_ID) String tableId, 
      @QueryParam (PARAM_APP_LEVEL_FILES) String appLevel) throws IOException;
  
}