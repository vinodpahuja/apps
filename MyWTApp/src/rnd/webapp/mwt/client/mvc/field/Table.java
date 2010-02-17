package rnd.webapp.mwt.client.mvc.field;

import rnd.webapp.mwt.client.bean._BoundList;
import rnd.webapp.mwt.client.data.ColumnMetaData;
import rnd.webapp.mwt.client.data.DataTable;
import rnd.webapp.mwt.client.data.Row;

public interface Table extends Field {

	int BEAN_BASED = 0;

	int ROW_BASED = 1;

	// Table Column Meta Data
	String COLUMN_META_DATA = "columnMetaData";

	void setColumnMetaDatas(ColumnMetaData[] columnMetaData);

	ColumnMetaData[] getColumnMetaDatas();

	// Table Model
	public interface TableModel extends FieldModel {

		boolean isUpdatable();

		void initialiseListner();

	}

	// Row Table Model
	public interface RowTableModel extends TableModel {

		// Data Table
		String DATA_TABLE = "dataTable";

		void setDataTable(DataTable dataTable);

		DataTable getDataTable();

		String CURRENT_ROW = "currentRow";

		Row getCurrentRow();

		void addRow(Row newRow);

		void addRow(int index, Row newRow);

		void removeRow(Row row);

		void removeCurrentRow();

		void updateRow(Row oldRow, Row newRow);

		void updateCurrentRow(Row newRow);
	}

	// _Bean Table Model
	public interface BeanTableModel extends TableModel {

		interface RowDelegate {
			Object newRow();
		}

		// Row Delegate
		String ROW_DELEGATE = "rowDelegate";

		void setRowDelegate(RowDelegate rowDelegate);

		RowDelegate getRowDelegate();

		// Data List
		String DATA_LIST = "dataList";

		void setDataList(_BoundList dataList);

		_BoundList getDataList();

		public void insertRow();

		void removeRow(int index);
	}

	// Table View
	public interface TableView extends FieldView {

		void refresh();

		void initialiseListner();

	}

	public interface BeanTableView extends TableView {

	}

}