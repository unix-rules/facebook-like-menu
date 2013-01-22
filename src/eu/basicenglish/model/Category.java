package eu.basicenglish.model;

public class Category extends Model {
	private String categoryName;
	private Integer categoryId;
	private Float percentage;  // brak settera
	
	
	public Float getPercentage() {
		return percentage;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String sql_save() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String sql_create() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String sql_load(Integer entityId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String sql_delete(Integer entityId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static String sql_load() {
		return "select a.*, count(b.correct_answers) from categories a left join word_records b on a.category_id = b.category_id group by b.correct_answers";
	}
}
