package fr.mouvement.reso2rav.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.mouvement.reso2rav.core.domain.TypeProduit;

@Controller
public class TypeProduitController {

	@GetMapping("/typeProduits")
	@ResponseBody
	public List<String> getTypeProduits() {

		return Arrays.asList(TypeProduit.values()).stream().map(TypeProduit::name).sorted()
				.collect(Collectors.toList());

	}

}
