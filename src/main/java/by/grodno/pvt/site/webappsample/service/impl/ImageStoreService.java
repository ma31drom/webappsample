package by.grodno.pvt.site.webappsample.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import by.grodno.pvt.site.webappsample.dto.Avatar;
import by.grodno.pvt.site.webappsample.service.StorageService;
import by.grodno.pvt.site.webappsample.service.UserService;

@Service
public class ImageStoreService implements StorageService {

	@Autowired
	UserService service;

	@Override
	public void store(Integer id, MultipartFile file) throws IOException {
		String string = UUID.randomUUID().toString();
		OldUser user = service.getUser(id);

		File file2 = new File(string);

		user.setAvatarFileName(file2.getAbsolutePath());

		try (InputStream in = file.getInputStream(); OutputStream out = new FileOutputStream(file2)) {
			IOUtils.copy(in, out);
		}
		service.saveUser(user);
	}

	@Override
	public Avatar getFile(Integer id) {
		OldUser user = service.getUser(id);
		if (user.getAvatarFileName() != null) {
			Avatar avatar = new Avatar();
			avatar.setFullFilePath(user.getAvatarFileName());
			return avatar;
		}
		return null;
	}

}
