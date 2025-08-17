package in.app.springboot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role 
{
	@JsonProperty("user_role_id")
	private Integer roleId;
	@JsonProperty("user_role_code")
	private String roleCode;
	

}
