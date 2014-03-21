/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.messageboards;

import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.settings.BaseServiceSettings;
import com.liferay.portal.settings.FallbackPaths;
import com.liferay.portal.settings.Settings;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.messageboards.util.MBUtil;
import com.liferay.util.ContentUtil;
import com.liferay.util.RSSUtil;

/**
 * @author Jorge Ferrer
 */
public class MBSettings extends BaseServiceSettings {

	public MBSettings(Settings settings) {
		super(settings, _fallbackPaths);
	}

	public String getEmailFromAddress() {
		return typedSettings.getValue("emailFromAddress");
	}

	public String getEmailFromName() {
		return typedSettings.getValue("emailFromName");
	}

	public String getEmailMessageAddedBody() {
		String emailMessageAddedBody = typedSettings.getValue(
			"emailMessageAddedBody");

		if (Validator.isNotNull(emailMessageAddedBody)) {
			return emailMessageAddedBody;
		}

		return ContentUtil.get(
			typedSettings.getValue(
				PropsKeys.MESSAGE_BOARDS_EMAIL_MESSAGE_ADDED_BODY));
	}

	public String getEmailMessageAddedSubject() {
		String emailMessageAddedSubject = typedSettings.getValue(
			"emailMessageAddedSubject");

		if (Validator.isNotNull(emailMessageAddedSubject)) {
			return emailMessageAddedSubject;
		}

		return ContentUtil.get(
			typedSettings.getValue(
				PropsKeys.MESSAGE_BOARDS_EMAIL_MESSAGE_ADDED_SUBJECT));
	}

	public String getEmailMessageUpdatedBody() {
		String emailMessageUpdatedBody = typedSettings.getValue(
			"emailMessageUpdatedBody");

		if (Validator.isNotNull(emailMessageUpdatedBody)) {
			return emailMessageUpdatedBody;
		}

		return ContentUtil.get(
			typedSettings.getValue(
				PropsKeys.MESSAGE_BOARDS_EMAIL_MESSAGE_UPDATED_BODY));
	}

	public String getEmailMessageUpdatedSubject() {
		String emailMessageUpdatedSubject = typedSettings.getValue(
			"emailMessageUpdatedSubject");

		if (Validator.isNotNull(emailMessageUpdatedSubject)) {
			return emailMessageUpdatedSubject;
		}

		return ContentUtil.get(
			typedSettings.getValue(
				PropsKeys.MESSAGE_BOARDS_EMAIL_MESSAGE_UPDATED_SUBJECT));
	}

	public String getMessageFormat() {
		String messageFormat = typedSettings.getValue("messageFormat");

		if (MBUtil.isValidMessageFormat(messageFormat)) {
			return messageFormat;
		}

		return "html";
	}

	public String[] getPriorities(String currentLanguageId) {
		return LocalizationUtil.getSettingsValues(
			typedSettings, "priorities", currentLanguageId);
	}

	public String[] getRanks(String languageId) {
		return LocalizationUtil.getSettingsValues(
			typedSettings, "ranks", languageId);
	}

	public String getRecentPostsDateOffset() {
		return typedSettings.getValue("recentPostsDateOffset");
	}

	public int getRSSDelta() {
		return typedSettings.getIntegerValue("rssDelta");
	}

	public String getRSSDisplayStyle() {
		return typedSettings.getValue(
			"rssDisplayStyle", RSSUtil.DISPLAY_STYLE_FULL_CONTENT);
	}

	public String getRSSFeedType() {
		return typedSettings.getValue(
			"rssFeedType", RSSUtil.getFeedType(RSSUtil.ATOM, 1.0));
	}

	public boolean isAllowAnonymousPosting() {
		return typedSettings.getBooleanValue("allowAnonymousPosting");
	}

	public boolean isEmailHtmlFormat() {
		return typedSettings.getBooleanValue("emailHtmlFormat");
	}

	public boolean isEmailMessageAddedEnabled() {
		return typedSettings.getBooleanValue("emailMessageAddedEnabled");
	}

	public boolean isEmailMessageUpdatedEnabled() {
		return typedSettings.getBooleanValue("emailMessageUpdatedEnabled");
	}

	public boolean isEnableFlags() {
		return typedSettings.getBooleanValue("enableFlags");
	}

	public boolean isEnableRatings() {
		return typedSettings.getBooleanValue("enableRatings");
	}

	public boolean isEnableRSS() {
		if (!PortalUtil.isRSSFeedsEnabled()) {
			return false;
		}

		return typedSettings.getBooleanValue("enableRss");
	}

	public boolean isSubscribeByDefault() {
		return typedSettings.getBooleanValue("subscribeByDefault");
	}

	public boolean isThreadAsQuestionByDefault() {
		return typedSettings.getBooleanValue("threadAsQuestionByDefault");
	}

	private static FallbackPaths _getFallbackPaths() {
		FallbackPaths fallbackPaths = new FallbackPaths();

		fallbackPaths.addPath(
			"allowAnonymousPosting",
			PropsKeys.MESSAGE_BOARDS_ANONYMOUS_POSTING_ENABLED);

		fallbackPaths.addPath(
			"emailFromAddress", PropsKeys.MESSAGE_BOARDS_EMAIL_FROM_ADDRESS,
			PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

		fallbackPaths.addPath(
			"emailFromName", PropsKeys.MESSAGE_BOARDS_EMAIL_FROM_NAME,
			PropsKeys.ADMIN_EMAIL_FROM_NAME);

		fallbackPaths.addPath(
			"emailHtmlFormat", PropsKeys.MESSAGE_BOARDS_EMAIL_HTML_FORMAT);

		fallbackPaths.addPath(
			"emailMessageAddedEnabled",
			PropsKeys.MESSAGE_BOARDS_EMAIL_MESSAGE_ADDED_ENABLED);

		fallbackPaths.addPath(
			"emailMessageUpdatedEnabled",
			PropsKeys.MESSAGE_BOARDS_EMAIL_MESSAGE_UPDATED_ENABLED);

		fallbackPaths.addPath(
			"enableFlags", PropsKeys.MESSAGE_BOARDS_FLAGS_ENABLED);

		fallbackPaths.addPath(
			"enableRatings", PropsKeys.MESSAGE_BOARDS_RATINGS_ENABLED);

		fallbackPaths.addPath("enableRss", PropsKeys.MESSAGE_BOARDS_RSS_ENABLED);

		fallbackPaths.addPath(
			"messageFormat", PropsKeys.MESSAGE_BOARDS_MESSAGE_FORMATS_DEFAULT);

		fallbackPaths.addPath(
			"priorities", PropsKeys.MESSAGE_BOARDS_THREAD_PRIORITIES);

		fallbackPaths.addPath("ranks", PropsKeys.MESSAGE_BOARDS_USER_RANKS);

		fallbackPaths.addPath(
			"recentPostsDateOffset",
			PropsKeys.MESSAGE_BOARDS_RECENT_POSTS_DATE_OFFSET);

		fallbackPaths.addPath(
			"rssDelta", PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA);

		fallbackPaths.addPath(
			"rssDisplayStyle", PropsKeys.RSS_FEED_DISPLAY_STYLE_DEFAULT);

		fallbackPaths.addPath("rssFeedType", PropsKeys.RSS_FEED_TYPE_DEFAULT);

		fallbackPaths.addPath(
			"subscribeByDefault",
			PropsKeys.MESSAGE_BOARDS_SUBSCRIBE_BY_DEFAULT);

		return fallbackPaths;
	}

	private static FallbackPaths _fallbackPaths = _getFallbackPaths();

}