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

package org.lsp.liferay.portlet.socialliving.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import org.lsp.liferay.portlet.socialliving.model.ChannelEntry;
import org.lsp.liferay.portlet.socialliving.service.ChannelEntryLocalService;
import org.lsp.liferay.portlet.socialliving.service.EventEntryLocalService;
import org.lsp.liferay.portlet.socialliving.service.EventEntryService;
import org.lsp.liferay.portlet.socialliving.service.EventRegistrationLocalService;
import org.lsp.liferay.portlet.socialliving.service.persistence.ChannelEntryPersistence;
import org.lsp.liferay.portlet.socialliving.service.persistence.EventEntryPersistence;
import org.lsp.liferay.portlet.socialliving.service.persistence.EventRegistrationPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the channel entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.lsp.liferay.portlet.socialliving.service.impl.ChannelEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.lsp.liferay.portlet.socialliving.service.impl.ChannelEntryLocalServiceImpl
 * @see org.lsp.liferay.portlet.socialliving.service.ChannelEntryLocalServiceUtil
 * @generated
 */
public abstract class ChannelEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ChannelEntryLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.lsp.liferay.portlet.socialliving.service.ChannelEntryLocalServiceUtil} to access the channel entry local service.
	 */

	/**
	 * Adds the channel entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param channelEntry the channel entry
	 * @return the channel entry that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ChannelEntry addChannelEntry(ChannelEntry channelEntry)
		throws SystemException {
		channelEntry.setNew(true);

		return channelEntryPersistence.update(channelEntry, false);
	}

	/**
	 * Creates a new channel entry with the primary key. Does not add the channel entry to the database.
	 *
	 * @param channelEntryId the primary key for the new channel entry
	 * @return the new channel entry
	 */
	public ChannelEntry createChannelEntry(long channelEntryId) {
		return channelEntryPersistence.create(channelEntryId);
	}

	/**
	 * Deletes the channel entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param channelEntryId the primary key of the channel entry
	 * @return the channel entry that was removed
	 * @throws PortalException if a channel entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public ChannelEntry deleteChannelEntry(long channelEntryId)
		throws PortalException, SystemException {
		return channelEntryPersistence.remove(channelEntryId);
	}

	/**
	 * Deletes the channel entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param channelEntry the channel entry
	 * @return the channel entry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public ChannelEntry deleteChannelEntry(ChannelEntry channelEntry)
		throws SystemException {
		return channelEntryPersistence.remove(channelEntry);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ChannelEntry.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return channelEntryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return channelEntryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return channelEntryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return channelEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public ChannelEntry fetchChannelEntry(long channelEntryId)
		throws SystemException {
		return channelEntryPersistence.fetchByPrimaryKey(channelEntryId);
	}

	/**
	 * Returns the channel entry with the primary key.
	 *
	 * @param channelEntryId the primary key of the channel entry
	 * @return the channel entry
	 * @throws PortalException if a channel entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry getChannelEntry(long channelEntryId)
		throws PortalException, SystemException {
		return channelEntryPersistence.findByPrimaryKey(channelEntryId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return channelEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the channel entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of channel entries
	 * @param end the upper bound of the range of channel entries (not inclusive)
	 * @return the range of channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChannelEntry> getChannelEntries(int start, int end)
		throws SystemException {
		return channelEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of channel entries.
	 *
	 * @return the number of channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public int getChannelEntriesCount() throws SystemException {
		return channelEntryPersistence.countAll();
	}

	/**
	 * Updates the channel entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param channelEntry the channel entry
	 * @return the channel entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ChannelEntry updateChannelEntry(ChannelEntry channelEntry)
		throws SystemException {
		return updateChannelEntry(channelEntry, true);
	}

	/**
	 * Updates the channel entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param channelEntry the channel entry
	 * @param merge whether to merge the channel entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the channel entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ChannelEntry updateChannelEntry(ChannelEntry channelEntry,
		boolean merge) throws SystemException {
		channelEntry.setNew(false);

		return channelEntryPersistence.update(channelEntry, merge);
	}

	/**
	 * Returns the channel entry local service.
	 *
	 * @return the channel entry local service
	 */
	public ChannelEntryLocalService getChannelEntryLocalService() {
		return channelEntryLocalService;
	}

	/**
	 * Sets the channel entry local service.
	 *
	 * @param channelEntryLocalService the channel entry local service
	 */
	public void setChannelEntryLocalService(
		ChannelEntryLocalService channelEntryLocalService) {
		this.channelEntryLocalService = channelEntryLocalService;
	}

	/**
	 * Returns the channel entry persistence.
	 *
	 * @return the channel entry persistence
	 */
	public ChannelEntryPersistence getChannelEntryPersistence() {
		return channelEntryPersistence;
	}

	/**
	 * Sets the channel entry persistence.
	 *
	 * @param channelEntryPersistence the channel entry persistence
	 */
	public void setChannelEntryPersistence(
		ChannelEntryPersistence channelEntryPersistence) {
		this.channelEntryPersistence = channelEntryPersistence;
	}

	/**
	 * Returns the event entry local service.
	 *
	 * @return the event entry local service
	 */
	public EventEntryLocalService getEventEntryLocalService() {
		return eventEntryLocalService;
	}

	/**
	 * Sets the event entry local service.
	 *
	 * @param eventEntryLocalService the event entry local service
	 */
	public void setEventEntryLocalService(
		EventEntryLocalService eventEntryLocalService) {
		this.eventEntryLocalService = eventEntryLocalService;
	}

	/**
	 * Returns the event entry remote service.
	 *
	 * @return the event entry remote service
	 */
	public EventEntryService getEventEntryService() {
		return eventEntryService;
	}

	/**
	 * Sets the event entry remote service.
	 *
	 * @param eventEntryService the event entry remote service
	 */
	public void setEventEntryService(EventEntryService eventEntryService) {
		this.eventEntryService = eventEntryService;
	}

	/**
	 * Returns the event entry persistence.
	 *
	 * @return the event entry persistence
	 */
	public EventEntryPersistence getEventEntryPersistence() {
		return eventEntryPersistence;
	}

	/**
	 * Sets the event entry persistence.
	 *
	 * @param eventEntryPersistence the event entry persistence
	 */
	public void setEventEntryPersistence(
		EventEntryPersistence eventEntryPersistence) {
		this.eventEntryPersistence = eventEntryPersistence;
	}

	/**
	 * Returns the event registration local service.
	 *
	 * @return the event registration local service
	 */
	public EventRegistrationLocalService getEventRegistrationLocalService() {
		return eventRegistrationLocalService;
	}

	/**
	 * Sets the event registration local service.
	 *
	 * @param eventRegistrationLocalService the event registration local service
	 */
	public void setEventRegistrationLocalService(
		EventRegistrationLocalService eventRegistrationLocalService) {
		this.eventRegistrationLocalService = eventRegistrationLocalService;
	}

	/**
	 * Returns the event registration persistence.
	 *
	 * @return the event registration persistence
	 */
	public EventRegistrationPersistence getEventRegistrationPersistence() {
		return eventRegistrationPersistence;
	}

	/**
	 * Sets the event registration persistence.
	 *
	 * @param eventRegistrationPersistence the event registration persistence
	 */
	public void setEventRegistrationPersistence(
		EventRegistrationPersistence eventRegistrationPersistence) {
		this.eventRegistrationPersistence = eventRegistrationPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("org.lsp.liferay.portlet.socialliving.model.ChannelEntry",
			channelEntryLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"org.lsp.liferay.portlet.socialliving.model.ChannelEntry");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return ChannelEntry.class;
	}

	protected String getModelClassName() {
		return ChannelEntry.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = channelEntryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ChannelEntryLocalService.class)
	protected ChannelEntryLocalService channelEntryLocalService;
	@BeanReference(type = ChannelEntryPersistence.class)
	protected ChannelEntryPersistence channelEntryPersistence;
	@BeanReference(type = EventEntryLocalService.class)
	protected EventEntryLocalService eventEntryLocalService;
	@BeanReference(type = EventEntryService.class)
	protected EventEntryService eventEntryService;
	@BeanReference(type = EventEntryPersistence.class)
	protected EventEntryPersistence eventEntryPersistence;
	@BeanReference(type = EventRegistrationLocalService.class)
	protected EventRegistrationLocalService eventRegistrationLocalService;
	@BeanReference(type = EventRegistrationPersistence.class)
	protected EventRegistrationPersistence eventRegistrationPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ChannelEntryLocalServiceClpInvoker _clpInvoker = new ChannelEntryLocalServiceClpInvoker();
}