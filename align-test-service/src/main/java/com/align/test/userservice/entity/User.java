package com.align.test.userservice.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import com.align.test.userservice.request.UserRequest;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name="USERS")
public class User {
	
	
	//@Id
    //private UUID userId = UUID.randomUUID();
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid4")
	private UUID userId =UUID.randomUUID();

    @Column(name="USERNAME")
    private String userName;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="EMAIL")
    private String email;
    
    
   @OneToMany(fetch = FetchType.EAGER) 
   @JoinTable(
			name = "USER_ROLES",
			joinColumns = @JoinColumn(name = "userId"),
			inverseJoinColumns = @JoinColumn(name = "roleId")
	)
    private Set<Role> roles= new HashSet<>();
    
   
   /*Example:
	    @ManyToOne
	    @JoinColumns({
	        @JoinColumn(name="ADDR_ID", referencedColumnName="ID"),
	        @JoinColumn(name="ADDR_ZIP", referencedColumnName="ZIP")
	    })
	    public Address getAddress() { return address; }
	 
*/
    
   /* @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "USER_ROLES", joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
    private Set<UserRoles> userRoles;*/
    
    public User (UserRequest userRequest) {
		this.userName = userRequest.getUserName();
		this.password = userRequest.getPassword();
		this.email = userRequest.getEmail();
	}

}
