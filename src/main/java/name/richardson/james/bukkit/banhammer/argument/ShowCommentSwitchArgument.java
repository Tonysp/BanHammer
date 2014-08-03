/*******************************************************************************
 Copyright (c) 2014 James Richardson.

 ShowCommentSwitchArgument.java is part of BanHammer.

 BanHammer is free software: you can redistribute it and/or modify it
 under the terms of the GNU General Public License as published by the Free
 Software Foundation, either version 3 of the License, or (at your option) any
 later version.

 BanHammer is distributed in the hope that it will be useful, but WITHOUT ANY
 WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

 You should have received a copy of the GNU General Public License along with
 BanHammer. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package name.richardson.james.bukkit.banhammer.argument;

import name.richardson.james.bukkit.utilities.command.argument.ArgumentMetadata;
import name.richardson.james.bukkit.utilities.command.argument.SimpleArgumentMetadata;
import name.richardson.james.bukkit.utilities.command.argument.SimpleBooleanMarshaller;
import name.richardson.james.bukkit.utilities.command.argument.SwitchArgument;

import name.richardson.james.bukkit.banhammer.Messages;
import name.richardson.james.bukkit.banhammer.MessagesFactory;

public class ShowCommentSwitchArgument extends SimpleBooleanMarshaller {

	public static final Messages MESSAGES = MessagesFactory.getMessages();

	public static ShowCommentSwitchArgument getInstance() {
		ArgumentMetadata metadata = new SimpleArgumentMetadata(MESSAGES.commentArgumentId(), MESSAGES.commentArgumentName(), MESSAGES.commentArgumentDescription());
		return new ShowCommentSwitchArgument(metadata);
	}

	private ShowCommentSwitchArgument(final ArgumentMetadata metadata) {
		super(new SwitchArgument(metadata));
	}


}