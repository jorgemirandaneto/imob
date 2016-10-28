package br.com.jlib.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@SuppressWarnings("serial")
@ManagedBean(name = "principalBean")
@ViewScoped
public class PrincipalBean implements Serializable {

	private List<String> images;

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	@PostConstruct
	public void init() {
		telaMovel();
	}
	
	
	//metodo para passar as imagens
	public void telaMovel(){
		images = new ArrayList<String>();
		for (int i = 1; i <= 2; i++) {
			images.add("imagem" + i + ".jpg");
		}
	}

}
