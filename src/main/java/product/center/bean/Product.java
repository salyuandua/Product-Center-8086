package product.center.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="product")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8915127292133638004L;

	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="product_name")
	@NotBlank
	private String name;
	
	@Column(name="project_inventory")
	
	private int inventory;
	
	@Column(name="product_price")
	private double price;
	
	@Column(name="product_description")
	private String description;
	
//	@OneToMany(cascade=CascadeType.ALL,targetEntity=Company.class)
//	@JoinColumn(name="product_company")
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=Company.class)
	@JoinColumn(name="product_company")
	private Company company;

	@ManyToOne(cascade=CascadeType.ALL,targetEntity=Department.class)
	@JoinColumn(name="product_department")
	private Department department;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", inventory=" + inventory + ", price=" + price
				+ ", description=" + description + ", company=" + company + "]";
	}
	
	
	
	
}
