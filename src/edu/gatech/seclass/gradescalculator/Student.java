package edu.gatech.seclass.gradescalculator;


public class Student{
	
	private String name;
	private String gtid;
	private String team;
	private int attendance;
	private String email;
	
	public Student(String name, String gtid){
		
		this.name = name;
		this.gtid = gtid;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gtid == null) ? 0 : gtid.hashCode());
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
		Student other = (Student) obj;
		if (gtid == null) {
			if (other.gtid != null)
				return false;
		} else if (!gtid.equals(other.gtid))
			return false;
		return true;
	}

	public Student(){
		
		
	}
	
	public String getName() {
		return name;
	}

	public int getAttendance() {
		
		return attendance;
	}

	public String getTeam() {
	
		return team;
	}

	public String getGtid() {
		return gtid;
	}
	
	public String getEmail(){
		return email;
	}

	public void setName(String name) {
		this.name=name;
		
	}

	public void setGtid(String gtid) {
		this.gtid=gtid;
		
	}

	public void setTeam(String team){
		
		this.team=team;
	}

	public void setAttendance(int attendance){
		this.attendance=attendance;
	}
	
	


	public void setEmail(String email) {
		this.email=email;
		
	}

	

}