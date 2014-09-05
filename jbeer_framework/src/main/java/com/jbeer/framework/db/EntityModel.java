/**   
* @Title: EntityModel.java
* @Package com.jbeer.framework.db
* @author Bieber
* @date 2014年6月4日 上午9:13:35
* @version V1.0   
*/

package com.jbeer.framework.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* <p>类功能说明:实体描述类</p>
* <p>类修改者	    修改日期</p>
* <p>修改说明</p>
* <p>Title: EntityModel.java</p>
* @author Bieber <a mailto="bieber.jbeer@hotmail.com">bieber.jbeer@hotmail.com</a>
* @date 2014年6月4日 上午9:13:35
* @version V1.0
*/

public class EntityModel {

    private String entityName;
    
    private Class<?> entityType;
    
    private Map<String ,ColumnModel> columns;
    
    private boolean useGeneratedKeySupport;
    
    private String autoGeneratedColumnName;
    
    private String primaryKeyName;
    
    
    

    /**
    * @return primaryKeyName
    */
    
    public String getPrimaryKeyName() {
        return primaryKeyName;
    }

    /**
    * @param primaryKeyName primaryKeyName
    */
    
    public void setPrimaryKeyName(String primaryKeyName) {
        this.primaryKeyName = primaryKeyName;
    }

    /**
	 * @return autoGeneratedColumnName
	 */
	
	public String getAutoGeneratedColumnName() {
		return autoGeneratedColumnName;
	}

	/**
	 * @param autoGeneratedColumnName autoGeneratedColumnName
	 */
	
	public void setAutoGeneratedColumnName(String autoGeneratedColumnName) {
		this.autoGeneratedColumnName = autoGeneratedColumnName;
	}

	/**
    * @return entityType
     * @throws Exception 
    */
    
    public Object getEntityInstance() throws Exception {
        return entityType.newInstance();
    }

    /**
    * @param entityType entityType
    */
    
    public void setEntityType(Class<?> entityType) {
        this.entityType = entityType;
    }

    /**
    * @return useGeneratedKeySupport
    */
    
    public boolean isUseGeneratedKeySupport() {
        return useGeneratedKeySupport;
    }

    /**
    * @param useGeneratedKeySupport useGeneratedKeySupport
    */
    
    public void setUseGeneratedKeySupport(boolean useGeneratedKeySupport) {
        this.useGeneratedKeySupport = useGeneratedKeySupport;
    }

    /**
    * @return entityName
    */
    
    public String getEntityName() {
        return entityName;
    }

    /**
    * @param entityName entityName
    */
    
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void registColumn(ColumnModel column){
        if(columns==null){
            columns =new HashMap<String,ColumnModel>();
        }
        columns.put(column.getColumnName().toUpperCase(), column);
    }
    public List<ColumnModel> getColumns(){
        if(columns==null){
            return null;
        }else{
            return new ArrayList<ColumnModel>(columns.values());
        }
    }
    
    public ColumnModel getColumn(String columnName){
        
        if(columns==null){
            return null;
        }else{
            return columns.get(columnName.toUpperCase());
        }
    }
    
}