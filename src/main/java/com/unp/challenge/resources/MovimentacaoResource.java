package com.unp.challenge.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unp.challenge.domain.Movimentacao;
import com.unp.challenge.services.MovimentacaoService;

@RestController
@RequestMapping(value="/movimentacoes")
public class MovimentacaoResource {
	
	@Autowired
	private MovimentacaoService service;
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ResponseEntity<Page<Movimentacao>> search(
			@RequestParam(value="dataInicio", required=false) String dataInicio,
			@RequestParam(value="dataFim", required=false) String dataFim,
			@RequestParam(value="tipoMovimentacao", required=false) String tipoMovimentacao,
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="15") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="dataCriacao") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) throws ParseException {
		
		
		Page<Movimentacao> list = service.search(new SimpleDateFormat("dd-MM-yyyy").parse(dataInicio), 
												 new SimpleDateFormat("dd-MM-yyyy").parse(dataFim), 
												 tipoMovimentacao, page, linesPerPage, orderBy, direction);
		
		return ResponseEntity.ok().body(list);
	}	
	
	/**
	 * Não solicitado, porém, caso preciso do crud de movimentações, basta descomentar.
	 * */
	/*@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Movimentacao> find(@PathVariable Integer id) {
		Movimentacao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Movimentacao obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Movimentacao obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}*/
	
	
}
