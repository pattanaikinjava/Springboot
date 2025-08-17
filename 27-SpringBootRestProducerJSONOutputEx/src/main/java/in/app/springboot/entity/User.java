package in.app.springboot.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User 
{
	@JsonProperty("user_unq_id")
	private Integer userId;
	@JsonProperty("user_unq_name")
	private String userName;
	@JsonProperty("user_unq_role")
	private String userRole;
	@JsonIgnore
	private String password; 
	
	//@JsonIgnore
	private List<String> permissions;
	
	@JsonProperty("my_json_map")
	private Map<String,String> data;
}
