package com.uru.app.business.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import com.uru.app.business.service.IDocumentService;
import com.uru.app.model.FileUploadStatus;


/**
 * 
 * @author Rahul Dev
 * 
 */
public class DocumentServiceImpl implements IDocumentService {



	@Override
	public List<FileUploadStatus> writeFiles(String folderName, List<FileItem> fileItems, String destLocation) {
		List<FileUploadStatus> uploadStatusList = new ArrayList<>();
		File dir = new File(destLocation);
		if (!dir.exists())
			dir.mkdirs();
		for (FileItem item : fileItems) {
			String fileItemName = item.getName();
			if (StringUtils.isEmpty(fileItemName)) {
				fileItemName = folderName + "_doc_" + RandomStringUtils.random(6, true, true).toLowerCase();
			}
			String fileName = new File(fileItemName).getName();
			File file = new File(dir.getAbsolutePath() + File.separator + fileName);
			FileUploadStatus fileUploadStatus = new FileUploadStatus();
			if (!file.exists()) {
				try {
					item.write(file);
					fileUploadStatus.setMessage("File uploaded successfully " + fileName);
					fileUploadStatus.setSuccess(true);
				} catch (Exception e) {
					e.printStackTrace();
					fileUploadStatus.setMessage("File uploaded failed " + fileName + ", Error: " + e.getMessage());
					fileUploadStatus.setSuccess(false);
				}
			} else {
				fileUploadStatus.setMessage("File uploaded failed " + fileName + ", already exists.");
				fileUploadStatus.setSuccess(false);
			}
			fileUploadStatus.setUploadLocation(destLocation);
			fileUploadStatus.setUploadedFileName(fileName);
			uploadStatusList.add(fileUploadStatus);
		}

		return uploadStatusList;
	}

	@Override
	public File locateFileForDownload(String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return null;
		}
		File file = new File(fileName);
		if (!file.exists()) {
			return null;
		}

		if (file.isDirectory()) {
			return null;
		}
		return file;
	}

	@Override
	public String[] getAttachments(String srcDirectory) {
		try {
			File dir = new File(srcDirectory);
			if (dir.exists()) {
				// TODO All files??
				return dir.getAbsoluteFile().list();
			} else {
			}
		} catch (Exception _ex) {
			_ex.printStackTrace();
		}
		return null;
	}

//	@Override
//	public List<Long> saveCaseDocuments(@NotNull String caseId, @NotNull String taskKey, String varName,
//			@NotNull String[] fileNames, boolean temp, String uploadedBy) {
//
//		List<Long> caseDocIds = new ArrayList<>();
//
//		if (fileNames != null && fileNames.length > 0) {
//			for (int i = 0; i < fileNames.length; i++) {
//				CaseDocumentsEntity caseDocumentsEntity = new CaseDocumentsEntity();
//				caseDocumentsEntity.setCaseId(caseId);
//				caseDocumentsEntity.setCreatedBy(uploadedBy);
//				caseDocumentsEntity.setTaskKey(taskKey);
//				caseDocumentsEntity.setVariableName(varName);
//				caseDocumentsEntity.setTemp(temp);
//				caseDocumentsEntity.setDocumentPath(fileNames[i]);
//				// caseDocumentsEntity.setDocumentType();
//				ICaseDocumentsDao.FileType ft = null;
//				switch (FilenameUtils.getExtension(fileNames[i]).toLowerCase()) {
//				case "doc":
//				case "docx":
//					ft = ICaseDocumentsDao.FileType.DOC;
//					break;
//				case "jpg":
//				case "jpeg":
//					ft = ICaseDocumentsDao.FileType.JPG;
//					break;
//				case "png":
//					ft = ICaseDocumentsDao.FileType.PNG;
//					break;
//				case "pdf":
//					ft = ICaseDocumentsDao.FileType.PDF;
//					break;
//				case "csv":
//					ft = ICaseDocumentsDao.FileType.CSV;
//					break;
//				case "xls":
//					ft = ICaseDocumentsDao.FileType.XLS;
//					break;
//				case "xlsx":
//					ft = ICaseDocumentsDao.FileType.XLSX;
//					break;
//				default:
//					ft = ICaseDocumentsDao.FileType.DEFAULT;
//
//				}
//				caseDocumentsEntity.setFileType(ft);
//				if (null != caseDocumentsEntity.getDocumentPath()
//						&& !("null".equals(caseDocumentsEntity.getDocumentPath()))
//						&& !("".equals(caseDocumentsEntity.getDocumentPath()))) {
//					long caseDocId = documentsDao.saveCaseDocument(caseDocumentsEntity);
//					caseDocIds.add(caseDocId);
//					log.info("\t Saved document for caseId: " + caseId + ", " + caseDocId);
//
//				}
//				// caseDocumentsEntity.setHostName();
//			}
//
//		} else {
//			log.severe("Cannot deal with empty file list.");
//		}
//
//		return caseDocIds;
//	}

//	@Override
//	public List<CaseDocumentDto> getCaseDocuments(@NotNull String caseId) {
//		List<CaseDocumentsEntity> caseDocEntityList = documentsDao.getAllCaseDocuments(caseId, false);
//		List docDtoList = new ArrayList<>();
//		if (caseDocEntityList != null && !caseDocEntityList.isEmpty()) {
//			docDtoList.addAll(caseDocEntityList.stream().map(this::convertEntity2Dto).collect(Collectors.toList()));
//		}
//		return docDtoList;
//	}

//	private CaseDocumentDto convertEntity2Dto(@NotNull CaseDocumentsEntity caseDocumentsEntity) {
//		CaseDocumentDto caseDocumentDto = new CaseDocumentDto();
//
//		caseDocumentDto.setUploadedBy(caseDocumentsEntity.getCreatedBy());
//		caseDocumentDto.setUploadDate(caseDocumentsEntity.getCreatedDate());
//		caseDocumentDto.setDocId(caseDocumentsEntity.getId());
//		caseDocumentDto.setCaseId(caseDocumentsEntity.getCaseId());
//		caseDocumentDto.setDocPath(caseDocumentsEntity.getDocumentPath());
//		caseDocumentDto.setFileType(caseDocumentsEntity.getFileType().name());
//		caseDocumentDto.setTaskKey(caseDocumentsEntity.getTaskKey());
//		String taskName = configManager.getActiveNameForTask(caseDocumentsEntity.getTaskKey());
//		if (!StringUtils.isEmpty(taskName))
//			caseDocumentDto.setTaskName(taskName);
//		else
//			caseDocumentDto.setTaskName(caseDocumentsEntity.getTaskKey());
//		caseDocumentDto.setTempUpload(caseDocumentsEntity.getTemp());
//		caseDocumentDto.setVarName(caseDocumentsEntity.getVariableName());
//		return caseDocumentDto;
//	}

	@Override
	public boolean removeAttachment(String srcDirectory, String docName) {
//		log.info("Removing attachments started.");
		try {
			File dir = new File(srcDirectory);
			if (!dir.exists())
				throw new FileNotFoundException("Directory does not exist: " + srcDirectory);
			String fileName = new File(docName).getName();
			File file = new File(dir.getAbsolutePath() + File.separator + fileName);
			if (!file.exists())
				throw new FileNotFoundException("Document does not exist: " + docName);
			file.delete();
			if (dir.list().length == 0)
				dir.delete();
			return true;
		} catch (Exception _ex) {
//			log.log(Level.SEVERE, "Error while deleting case files from file system." + _ex.getMessage(), _ex);
			_ex.printStackTrace();
		}
		return false;
	}


//	public Map<String, String[]> getAttachmentsFromDB(String businessKey) {
//		Map<String, String[]> result = new HashMap<String, String[]>();
//		Map<String, String> data = caseBusinessService.fetchBusinessAttributesData(businessKey, null);
//		if (data.containsKey(RBC_DELIVERED_DOCS_KEY) && !data.get(RBC_DELIVERED_DOCS_KEY).isEmpty()) {
//			result.put(BusinessConstants.RBC_DELIVERY_PROOF_CSV, data.get(RBC_DELIVERED_DOCS_KEY).split(","));
//		}
//		if (data.containsKey(RBC_POD_DOCS_KEY) && !data.get(RBC_POD_DOCS_KEY).isEmpty()) {
//			result.put(BusinessConstants.COURIER_RECEIPT_FILE_CSV, data.get(RBC_POD_DOCS_KEY).split(","));
//		}
//		if (data.containsKey(RBC_FREIGHT_RECEIPTS_KEY) && !data.get(RBC_FREIGHT_RECEIPTS_KEY).isEmpty()) {
//			result.put(BusinessConstants.FREIGHT_RECEIPT_FILE_CSV, data.get(RBC_FREIGHT_RECEIPTS_KEY).split(","));
//		}
//		if (data.containsKey(RBC_FREIGHT_APPROVE_KEY) && !data.get(RBC_FREIGHT_APPROVE_KEY).isEmpty()) {
//			result.put(BusinessConstants.FREIGHT_APPROVAL_FILE_CSV, data.get(RBC_FREIGHT_APPROVE_KEY).split(","));
//		}	
//		
//		if (data.containsKey(ID_PROOF_DOCS_KEY) && !data.get(ID_PROOF_DOCS_KEY).isEmpty()) {
//			result.put(BusinessConstants.CONFIRM_ID_PROOF_FILE_CSV, data.get(ID_PROOF_DOCS_KEY).split(","));
//		}
//		if (data.containsKey(DISPUTE_RESOLUTION_PROOF_RBC_DOCS_KEY)
//				&& !data.get(DISPUTE_RESOLUTION_PROOF_RBC_DOCS_KEY).isEmpty()) {
//			result.put(BusinessConstants.DISPUTE_REJECTED_PROOF_CSV,
//					data.get(DISPUTE_RESOLUTION_PROOF_RBC_DOCS_KEY).split(","));
//		}
//		if (data.containsKey(DISPUTE_RESOLUTION_PROOF_RP_DOCS_KEY)
//				&& !data.get(DISPUTE_RESOLUTION_PROOF_RP_DOCS_KEY).isEmpty()) {
//			result.put(BusinessConstants.DISPUTE_REJECTED_PROOF_CSV, data.get(DISPUTE_RESOLUTION_PROOF_RP_DOCS_KEY).split(","));
//		}
//		if (data.containsKey(PRICE_VARIATION_PROOF_DOCS_KEY) && !data.get(PRICE_VARIATION_PROOF_DOCS_KEY).isEmpty()) {
//			result.put(BusinessConstants.PRICE_VARIATION_SNAPSHOT_CSV, data.get(PRICE_VARIATION_PROOF_DOCS_KEY).split(","));
//		}
//
//		if (data.containsKey(HOLD_CHEQUE_ID_PROOF_DOCS_KEY) && !data.get(HOLD_CHEQUE_ID_PROOF_DOCS_KEY).isEmpty()) {
//			result.put(BusinessConstants.HOLD_CHEQUE_CONFIRM_ID_PROOF_CSV, data.get(HOLD_CHEQUE_ID_PROOF_DOCS_KEY).split(","));
//		}
//
//		if (data.containsKey(BRAND_SC_FILE_CSV_KEY) && !data.get(BRAND_SC_FILE_CSV_KEY).isEmpty()) {
//			result.put(BusinessConstants.BRAND_SC_FILE_CSV, data.get(BRAND_SC_FILE_CSV_KEY).split(","));
//		}
//		if (data.containsKey(COURIER_EXRTA_AMT_PROOF_DOCS_KEY)
//				&& !data.get(COURIER_EXRTA_AMT_PROOF_DOCS_KEY).isEmpty()) {
//			result.put(BusinessConstants.COURIER_CHARGING_EXTRA_RECEIPTS,
//					data.get(COURIER_EXRTA_AMT_PROOF_DOCS_KEY).split(","));
//		}
//		if (data.containsKey(INVOICES_KEY) && !data.get(INVOICES_KEY).isEmpty()) {
//			result.put(BusinessConstants.SEND_INVOICE_INVOICES_CSV, data.get(INVOICES_KEY).split(","));
//		}
//		if (data.containsKey(CUSTOMER_ACCOUNT_DOC_CSV_KEY) && !data.get(CUSTOMER_ACCOUNT_DOC_CSV_KEY).isEmpty()) {
//			result.put(BusinessConstants.CUSTOMER_ACCOUNT_DOC_CSV, data.get(CUSTOMER_ACCOUNT_DOC_CSV_KEY).split(","));
//		}
//		if (data.containsKey(REFUND_SUCCESSFUL_DOC_KEY) && !data.get(REFUND_SUCCESSFUL_DOC_KEY).isEmpty()) {
//			result.put(BusinessConstants.REFUND_SUCCESSFUL_DOC, data.get(REFUND_SUCCESSFUL_DOC_KEY).split(","));
//		}
//		if (data.containsKey(CUSTOMER_PAYMENT_ACCOUNT_PROOF_KEY)
//				&& !data.get(CUSTOMER_PAYMENT_ACCOUNT_PROOF_KEY).isEmpty()) {
//			result.put(BusinessConstants.CUSTOMER_PAYMENT_ACCOUNT_PROOF,
//					data.get(CUSTOMER_PAYMENT_ACCOUNT_PROOF_KEY).split(","));
//		}
//		if (data.containsKey(ONLINE_PAYMENT_NOT_RECEIVED_PROOF_KEY)
//				&& !data.get(ONLINE_PAYMENT_NOT_RECEIVED_PROOF_KEY).isEmpty()) {
//			result.put(BusinessConstants.ONLINE_PAYMENT_NOT_RECEIVED_PROOF,
//					data.get(ONLINE_PAYMENT_NOT_RECEIVED_PROOF_KEY).split(","));
//		}
//		return result;
//	}
}