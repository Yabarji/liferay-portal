/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.document.library.preview;

import com.liferay.portal.kernel.exception.PortalException;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Renders file previews in conjunction with {@link DLPreviewRendererProvider}.
 *
 * @author Alejandro Tardín
 * @review
 */
public interface DLPreviewRenderer {

	/**
	 * Renders content to the response.
	 *
	 * See {@link DLPreviewRendererProvider#getPreviewDLPreviewRendererOptional(FileVersion)}
	 * and {@link DLPreviewRendererProvider#getThumbnailDLPreviewRendererOptional(FileVersion)}
	 *
	 * @param request the request
	 * @param response the response
	 * @review
	 */
	public void render(HttpServletRequest request, HttpServletResponse response)
		throws IOException, PortalException, ServletException;

}