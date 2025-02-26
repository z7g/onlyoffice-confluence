/**
 *
 * (c) Copyright Ascensio System SIA 2023
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package onlyoffice.model.config.document;

import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import onlyoffice.managers.document.DocumentManager;
import onlyoffice.utils.attachment.AttachmentUtil;

public class Permissions {
    private boolean edit;

    public Permissions(final DocumentManager documentManager, final AttachmentUtil attachmentUtil,
                        final Long attachmentId) {
        String fileExt = attachmentUtil.getFileExt(attachmentId);
        boolean isEditable = documentManager.isEditable(fileExt) || documentManager.isFillForm(fileExt);
        edit = attachmentUtil.checkAccess(attachmentId,  AuthenticatedUserThreadLocal.get(), true) && isEditable;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(final boolean edit) {
        this.edit = edit;
    }
}
