package com.uol.host.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uol.host.controllers.dtos.CodenameFileDTO;
import com.uol.host.controllers.dtos.CodenameXMLFileDTO;
import com.uol.host.service.CodenameService;
import com.uol.host.service.interfaces.PersistAvengersCodenamesInterface;
import com.uol.host.service.interfaces.PersistJusticeLeagueCodenamesInterface;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RequiredArgsConstructor
@RestController
@RequestMapping("/codename")
public class CodenameController {
  private final CodenameService codenameService;

  @PostMapping("/json")
  public void RegisterCodenamesFromJsonFile(@RequestParam("file-json") MultipartFile fileJson)
      throws Exception {
    var mapper = new ObjectMapper();
    var obj = mapper.readValue(fileJson.getInputStream(), CodenameFileDTO.class);

    var input = obj.vingadores().stream().map(Record::toString).toList();

    this.codenameService.persistAvengersCodenames(
        new PersistAvengersCodenamesInterface.Input(input));
  }

  @PostMapping("/xml")
  public void RegisterCodenamesFromXmlFile(@RequestParam("file-xml") MultipartFile fileXml)
      throws Exception {
    JAXBContext context = JAXBContext.newInstance(CodenameXMLFileDTO.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();

    CodenameXMLFileDTO codenameXmlFileDTO =
        (CodenameXMLFileDTO) unmarshaller.unmarshal(fileXml.getInputStream());

    var input =
        new PersistJusticeLeagueCodenamesInterface.Input(
            codenameXmlFileDTO.getLigaDaJustica().getCodinome().stream().toList());

    this.codenameService.persistJusticeLeagueCodenames(input);
  }
}
