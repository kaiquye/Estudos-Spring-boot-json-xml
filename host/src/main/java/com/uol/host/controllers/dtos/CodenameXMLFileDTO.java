package com.uol.host.controllers.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "liga_da_justica")
@XmlAccessorType(XmlAccessType.FIELD)
public class CodenameXMLFileDTO {

  @XmlElement(name = "codinomes")
  private Codenames ligaDaJustica;

  public Codenames getLigaDaJustica() {
    return ligaDaJustica;
  }

  public void setLigaDaJustica(Codenames ligaDaJustica) {
    this.ligaDaJustica = ligaDaJustica;
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  public static class Codenames {
    @XmlElement(name = "codinome")
    private List<String> codinome;

    public List<String> getCodinome() {
      return codinome;
    }

    public void setCodinome(List<String> codinome) {
      this.codinome = codinome;
    }
  }
}