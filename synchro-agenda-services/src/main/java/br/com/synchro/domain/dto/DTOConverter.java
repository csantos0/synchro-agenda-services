package br.com.synchro.domain.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.synchro.domain.Contact;

/**
 * 
 * DTOConverter.java Criado em Sep 26, 2014
 * 
 * @author Ciro S. Santos
 * @version 1.0
 */
public class DTOConverter {

	public static List<ContactDTO> convertToList(List<Contact> list) {
		List<ContactDTO> listVO = new ArrayList<ContactDTO>();
		if (list != null) {
			for (Contact var : list) {
				ContactDTO vo = new ContactDTO();
				vo.setEmail(var.getEmail());
				vo.setId(var.getId());
				vo.setName(var.getName());
				vo.setPhone(var.getPhone());
				vo.setSurname(var.getSurname());

				if (var.getAddress() != null) {
					vo.setCity(var.getAddress().getCity());
					vo.setDistrict(var.getAddress().getDistrict());
					vo.setNumber(var.getAddress().getNumber());
					vo.setStreet(var.getAddress().getStreet());
					vo.setZipcode(var.getAddress().getZipcode());
				}

				listVO.add(vo);
			}
		}
		return listVO;
	}
}
