package com.uru.app.rest;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;

import com.uru.app.business.service.IDocumentService;
import com.uru.app.model.FileUploadStatus;

/**
 * @author Rahul Dev
 *
 */
@Path("/fileupload")
public class FileUploadRest {

	private static final String UPLOAD_DIRECTORY = "C:/Files";

	@Inject
	IDocumentService documentService;
	

	// @POST
	// @Path("/uploadBulkFile")
	// @Produces(MediaType.APPLICATION_JSON)
	// public Response uploadBulkFile(@Context HttpServletRequest request) {
	// FileItemFactory factory = new DiskFileItemFactory();
	// ServletFileUpload upload = new ServletFileUpload(factory);
	// String businessKey = null;
	// String subPath = null;
	//
	// List<FileItem> multiparts = null;
	// try {
	// multiparts = upload.parseRequest(request);
	// } catch (FileUploadException e) {
	// e.printStackTrace();
	// }
	// List<FileItem> fileItems = null;
	// List<FileItem> formFieldItems = null;
	//
	// Response attachResponse=Response.serverError().build();//default is
	// error.
	// if (multiparts != null && !multiparts.isEmpty()) {
	// fileItems = multiparts.stream().filter(mp -> {
	// return !mp.isFormField();
	// }).collect(Collectors.toList());
	//
	// formFieldItems = multiparts.stream().filter(mp -> {
	// return mp.isFormField();
	// }).collect(Collectors.toList());
	//
	//
	// if (formFieldItems != null && !formFieldItems.isEmpty()) {
	// Optional<FileItem> businessKeyOpt = formFieldItems.stream().filter(ffi ->
	// {
	// return
	// ffi.getFieldName().equalsIgnoreCase(BusinessConstants.BUSINESS_KEY);
	// }).findFirst();
	// if (businessKeyOpt != null && businessKeyOpt.isPresent()) {
	// businessKey = businessKeyOpt.get().getString();
	// }
	//
	// Optional<FileItem> subPathOpt = formFieldItems.stream().filter(ffi -> {
	// return ffi.getFieldName().equalsIgnoreCase("subPath");
	// }).findFirst();
	//
	// if (subPathOpt != null && subPathOpt.isPresent()) {
	// subPath = subPathOpt.get().getString();
	// }
	// } else {
	// throw new BusinessException("Cannot deal with null form fields. ERROR");
	// }
	//
	// if (StringUtils.isEmpty(businessKey) || StringUtils.isEmpty(subPath)) {
	// throw new BusinessException("Cannot deal with inappropriate data : " +
	// businessKey + "," + subPath);
	// }
	//
	// //now save the fileitems.
	// attachResponse = Response.serverError().build();
	// if (fileItems != null && !fileItems.isEmpty()) {
	// String tmpUrl = CASE_DOCUMENTS_UPLOAD_DIRECTORY + File.separator +
	// File.separator + businessKey;
	// if (subPath != null && !subPath.isEmpty()) {
	// tmpUrl = tmpUrl + File.separator + subPath;
	// }
	// List<FileUploadStatus> writeFileStatus =
	// documentService.writeFiles(businessKey,fileItems, tmpUrl);
	// attachResponse = createBulkResponse(writeFileStatus);
	// log.info("Completed upload of documents for : " + businessKey + ", " +
	// tmpUrl);
	// } else {
	// throw new BusinessException("Nothing to upload... null contents.");
	// }
	//
	//
	// } else {
	// log.severe("No mulitpart request found..");
	// throw new BusinessException("No multipart contents...");
	// }
	// return attachResponse;
	// }

	// private Response createBulkResponse(List<FileUploadStatus>
	// attachResponse) {
	// Response.ResponseBuilder builder = null;
	// Response response = null;
	// if (attachResponse != null && !attachResponse.isEmpty()) {
	// Entity<List<FileUploadStatus>> respEntity = Entity.entity(attachResponse,
	// MediaType.APPLICATION_JSON_TYPE);
	// builder = Response.status(200).entity(respEntity);
	// response = builder.build();
	// } else {
	// builder = Response.status(200).entity(
	// "Attachments transfer failed. Please try again");
	// response = builder.build();
	// }
	// return response;
	// }

	@POST
	@Path("/uploadFile")
	public Response upload(@Context HttpServletRequest request) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletContext servletContext = request.getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);
		ServletFileUpload upload = new ServletFileUpload(factory);
		String rootFolderName = null;
		String subFolderName = null;

		List<FileItem> multiparts = null;
		try {
			multiparts = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		List<FileItem> fileItems = null;
		List<FileItem> formFieldItems = null;

		Response attachResponse=Response.serverError().build();//default is error.
		if (multiparts != null && !multiparts.isEmpty()) {
			fileItems = multiparts.stream().filter(mp -> {
				return !mp.isFormField();
			}).collect(Collectors.toList());

			formFieldItems = multiparts.stream().filter(mp -> {
				return mp.isFormField();
			}).collect(Collectors.toList());


			if (formFieldItems != null && !formFieldItems.isEmpty()) {
				Optional<FileItem> businessKeyOpt = formFieldItems.stream().filter(ffi -> {
					return ffi.getFieldName().equalsIgnoreCase("rootFolder");
				}).findFirst();
				if (businessKeyOpt != null && businessKeyOpt.isPresent()) {
					rootFolderName = businessKeyOpt.get().getString();
				}

				Optional<FileItem> subPathOpt = formFieldItems.stream().filter(ffi -> {
					return ffi.getFieldName().equalsIgnoreCase("subFolder");
				}).findFirst();

				if (subPathOpt != null && subPathOpt.isPresent()) {
					subFolderName = subPathOpt.get().getString();
				}
			} else {
				throw new RuntimeException("Cannot deal with null form fields. ERROR");
			}

			if (StringUtils.isEmpty(rootFolderName) || StringUtils.isEmpty(subFolderName)) {
				throw new RuntimeException("Cannot deal with inappropriate data : " + rootFolderName + "," + subFolderName);
			}

			//now save the fileitems.
			attachResponse = Response.serverError().build();
			if (fileItems != null && !fileItems.isEmpty()) {
				String tmpUrl = UPLOAD_DIRECTORY + File.separator + File.separator + rootFolderName;
				if (subFolderName != null && !subFolderName.isEmpty()) {
					tmpUrl = tmpUrl + File.separator + subFolderName;
				}
				List<FileUploadStatus> writeFileStatus = documentService.writeFiles(rootFolderName,fileItems, tmpUrl);
				attachResponse = createResponse(writeFileStatus);
			} else {
				throw new RuntimeException("Nothing to upload... null contents.");
			}


		} else {
			throw new RuntimeException("No multipart contents...");
		}
		return attachResponse;
	}

	public Response createResponse(List<FileUploadStatus> attachResponse) {
		Response.ResponseBuilder builder = null;
		Response response = null;
		if (attachResponse != null && !attachResponse.isEmpty()) {
			// Entity<List<FileUploadStatus>> respEntity =
			// Entity.entity(attachResponse, MediaType.APPLICATION_JSON_TYPE);
			builder = Response.status(200).entity(attachResponse.toString());// bad
																				// but
																				// true.
			response = builder.build();
		} else {
			builder = Response.status(200).entity(
					"Attachments transfer failed. Please try again");
			response = builder.build();
		}
		return response;
	}

	public Response createTooLargeFileResponse() {
		Response.ResponseBuilder builder = null;
		Response response = null;
		builder = Response.status(200).entity(
				"Upload failed, file is too large.");
		response = builder.build();
		return response;
	}

//	@GET
//	@NoCache
//	@Path("/download")
//	@Produces(MediaType.APPLICATION_OCTET_STREAM)
//	public Response download(@QueryParam("fileName") String fileName) {
//		File downloadFile = documentService
//				.locateFileForDownload(CASE_DOCUMENTS_UPLOAD_DIRECTORY
//						+ File.separator + fileName);
//
//		Response.ResponseBuilder builder = null;
//		Response downloadResponse = null;
//		if (downloadFile == null) {
//			downloadResponse = Response.status(Response.Status.NOT_FOUND)
//					.entity("Invalid file name." + fileName).build();
//		} else {
//
//			String docName = FilenameUtils.getName(fileName);
//			builder = Response
//					.status(Response.Status.OK)
//					.entity((Object) downloadFile)
//					.header("Content-Disposition",
//							"attachment; filename=" + docName);
//			if (fileName.endsWith(".pdf")) {
//				builder.header("Content-Type", "application/pdf");
//			} else if (fileName.endsWith(".doc")) {
//				builder.header("Content-Type", "application/msword");
//			} else if (fileName.endsWith(".docx")) {
//				builder.header("Content-Type",
//						"application/vnd.openxmlformats-officedocument.wordprocessingml.document");
//			}
//			downloadResponse = builder.build();
//		}
//		return downloadResponse;
//	}

//	@GET
//	@NoCache
//	@Path("/existingDocsFs")
//	@Produces({ MediaType.APPLICATION_JSON })
//	public String[] getExistingDocsFs(
//			@QueryParam("businessKey") String businessKey,
//			@QueryParam("subPath") String subPath) {
//		String path = CASE_DOCUMENTS_UPLOAD_DIRECTORY + File.separator
//				+ File.separator + businessKey;
//		if (subPath != null && !subPath.isEmpty()) {
//			path = path + File.separator + subPath;
//		}
//		return documentService.getAttachments(path);
//	}
//
//	@GET
//	@NoCache
//	@Path("/removeDocsFs")
//	@Produces({ MediaType.APPLICATION_JSON })
//	public boolean removeCaseDocument(
//			@QueryParam("businessKey") String businessKey,
//			@QueryParam("subPath") String subPath,
//			@QueryParam("docName") String docName) {
//		String path = CASE_DOCUMENTS_UPLOAD_DIRECTORY + File.separator
//				+ File.separator + businessKey;
//		if (subPath != null && !subPath.isEmpty()) {
//			path = path + File.separator + subPath;
//		}
//		return documentService.removeAttachment(path, docName);
//		// return false;
//	}

//	@GET
//	@NoCache
//	@Path("/existingDocsDB")
//	@Produces({ MediaType.APPLICATION_JSON })
//	public List<CaseDocumentDto> getExistingDocsDB(
//			@QueryParam("businessKey") String businessKey) {
//		// return documentService.getAttachmentsFromDB(businessKey);
//		List<CaseDocumentDto> docs = documentService
//				.getCaseDocuments(businessKey);
//
//		return docs;
//	}
}
