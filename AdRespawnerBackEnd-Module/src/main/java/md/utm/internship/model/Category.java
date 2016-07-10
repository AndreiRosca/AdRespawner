package md.utm.internship.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<SubCategory> subCategories = new ArrayList<>();
	
	@XmlTransient
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private AdDomain adDomain;

	public Category() {
	}

	public Category(String name, AdDomain adDomain) {
		this.name = name;
		this.adDomain = adDomain;
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

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public AdDomain getAdDomain() {
		return adDomain;
	}
	
	public void setAdDomain(AdDomain adDomain) {
		this.adDomain = adDomain;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adDomain == null) ? 0 : adDomain.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (adDomain == null) {
			if (other.adDomain != null)
				return false;
		} else if (!adDomain.equals(other.adDomain))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", adDomain=" + adDomain + "]";
	}
}
