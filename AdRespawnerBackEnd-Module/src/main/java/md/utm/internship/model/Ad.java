package md.utm.internship.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Ad {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String description;
	private Date postingDate;
	
	@OneToOne(fetch = FetchType.EAGER)
	private User adAuthor;
	
	@Embedded
	private Price price;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Region region;
	
	@OneToMany
	private List<Photo> photos = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	private SubCategory subCategory;
	
	@ElementCollection
	private List<AdCharacteristic> characteristics = new ArrayList<>();

	public Ad() {
	}

	public Ad(String title, String description, Price price, Region region) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.region = region;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public User getAdAuthor() {
		return adAuthor;
	}

	public void setAdAuthor(User adAuthor) {
		this.adAuthor = adAuthor;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public List<AdCharacteristic> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<AdCharacteristic> characteristics) {
		this.characteristics = characteristics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adAuthor == null) ? 0 : adAuthor.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((postingDate == null) ? 0 : postingDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Ad other = (Ad) obj;
		if (adAuthor == null) {
			if (other.adAuthor != null)
				return false;
		} else if (!adAuthor.equals(other.adAuthor))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (postingDate == null) {
			if (other.postingDate != null)
				return false;
		} else if (!postingDate.equals(other.postingDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ad [id=" + id + ", title=" + title + ", description=" + description + ", postingDate=" + postingDate
				+ ", adAuthor=" + adAuthor + "]";
	}
}
