package com.uru.app.business.service;

import java.io.File;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.uru.app.model.FileUploadStatus;

/**
 * Created by Rahul Dev.
 */
public interface IDocumentService {
    List<FileUploadStatus> writeFiles(String folderName, List<FileItem> fileItems, String destLocation);

    File locateFileForDownload(String fileName);

    String[] getAttachments(String path);

//    List<Long> saveCaseDocuments(@NotNull String caseId,@NotNull  String taskKey,String varName, @NotNull String[] fileNames, boolean temp,String uploadedBy);

//    List<CaseDocumentDto> getCaseDocuments(@NotNull String caseId);

    boolean removeAttachment(String srcDirectory, String docName);
}
