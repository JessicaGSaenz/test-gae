package com.test.data;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * Book data bean
 */
@Entity
@Cache
@ApiModel("Book")
public class BookBean {

    @Id
    private Long id;

    private String data;
    
    private String name;
    
    private String author;
    
    private Integer year;
    
    private String genre;
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
		return name;
	}

	public void setName(String nombre) {
		this.name = nombre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String autor) {
		this.author = autor;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer anio) {
		this.year = anio;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genero) {
		this.genre = genero;
	}
	
	public String toSearch() {
		return id + "|" + name + "|" + author + "|" + year + "|" + genre;
	}
	
	public String toString() {
		return "Book [id=" + id + ", nombre=" + name + ", autor=" + author + ", anio=" + year + ", genero="
				+ genre + "]";
	}

}
