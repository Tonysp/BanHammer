/*******************************************************************************
 Copyright (c) 2014 James Richardson.

 CommentRecordFormatter.java is part of BanHammer.

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
package name.richardson.james.bukkit.banhammer.ban;

import java.util.Collection;

import name.richardson.james.bukkit.banhammer.model.CommentRecord;

/**
 * Created by james on 03/08/14.
 */
public interface CommentRecordFormatter {

	Collection<String> getMessages();

	void removeComments(CommentRecord.Type type);
}
