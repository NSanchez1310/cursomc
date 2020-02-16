package com.nsanchez1310.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.nsanchez1310.cursomc.domain.Cliente;
import com.nsanchez1310.cursomc.dto.ClienteDTO;
import com.nsanchez1310.cursomc.repositories.ClienteRepository;
import com.nsanchez1310.cursomc.resources.exceptions.FieldMessage;

public class ClientUpdateValidator implements ConstraintValidator<ClientUpdate, ClienteDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository repo;

	@Override
	public void initialize(ClientUpdate ann) {
	}

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		
		/* Truque para pegar o id da url lançada no endereço url Json
		 * 
		 */
		@SuppressWarnings("unchecked")
		Map<String, String>map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer urlId = Integer.parseInt(map.get("id"));

		List<FieldMessage> list = new ArrayList<>();
// inclua os testes aqui, inserindo erros na lista
		

		Cliente aux = repo.findByEmail(objDto.getEmail());
		
		if (aux != null && !aux.getId().equals(urlId)) {
			list.add(new FieldMessage("email", "Este email já existe"));
		}
		
		for (FieldMessage e : list) {

			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();

		}

		return list.isEmpty();
	}
}
