/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package org.lsp.liferay.portlet.socialliving.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import org.lsp.liferay.portlet.socialliving.model.EventEntry;
import org.lsp.liferay.portlet.socialliving.service.EventEntryLocalServiceUtil;

/**
 * The extended model base implementation for the EventEntry service. Represents a row in the &quot;LSPSL_EventEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EventEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventEntryImpl
 * @see org.lsp.liferay.portlet.socialliving.model.EventEntry
 * @generated
 */
public abstract class EventEntryBaseImpl extends EventEntryModelImpl
	implements EventEntry {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a event entry model instance should use the {@link EventEntry} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventEntryLocalServiceUtil.addEventEntry(this);
		}
		else {
			EventEntryLocalServiceUtil.updateEventEntry(this);
		}
	}
}