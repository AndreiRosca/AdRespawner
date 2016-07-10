package md.utm.internship.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
public class Photo {

	@Id
	@GeneratedValue
	private Long id;
	private String fileSystemPath;
	
	@XmlTransient
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Ad owningAd;

	public Photo() {
	}

	public Photo(String fileSystemPath) {
		this.fileSystemPath = fileSystemPath;
	}

	public Long getId() {
		return id;
	}

	public String getFileSystemPath() {
		return fileSystemPath;
	}

	public Ad getOwningAd() {
		return owningAd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileSystemPath == null) ? 0 : fileSystemPath.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Photo other = (Photo) obj;
		if (fileSystemPath == null) {
			if (other.fileSystemPath != null)
				return false;
		} else if (!fileSystemPath.equals(other.fileSystemPath))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", fileSystemPath=" + fileSystemPath + "]";
	}
}
