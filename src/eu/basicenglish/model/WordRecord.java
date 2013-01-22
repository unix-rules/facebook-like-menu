package eu.basicenglish.model;

public class WordRecord extends Model {
	private String from;
	private String fromDesc;
	private String to;
	private String toDesc;
	private String recordDescription;
	private Integer wordRecordId;
	private Integer correctAnswers; 
	
	public Integer getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(Integer correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public Integer getWordRecordId() {
		return wordRecordId;
	}

	public void setWordRecordId(Integer wordRecordId) {
		this.wordRecordId = wordRecordId;
	}

	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
	}
	
	public String getFromDesc() {
		return fromDesc;
	}
	
	public void setFromDesc(String fromDesc) {
		this.fromDesc = fromDesc;
	}
	
	public String getToDesc() {
		return toDesc;
	}
	
	public void setToDesc(String toDesc) {
		this.toDesc = toDesc;
	}
	
	public String getRecordDescription() {
		return recordDescription;
	}
	
	public void setRecordDescription(String recordDescription) {
		this.recordDescription = recordDescription;
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
}
