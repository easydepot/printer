package core.printing.visitor;

import org.junit.Test;

public interface TestVisitor {

	public abstract void test_SimpleText() throws Exception;

	public abstract void test_SimpleText_italic() throws Exception;

	public abstract void test_SimpleText_color() throws Exception;

	public abstract void test_WarningText() throws Exception;

	public abstract void test_SimpleText_bold() throws Exception;

	public abstract void test_SimpleText_strikeThrough() throws Exception;

	public abstract void test_FixedSize();

	public abstract void test_SpecialSize();

	public abstract void test_Section() throws Exception;

	public abstract void test_that_latexize_protect_percent_char()
			throws Exception;

	public abstract void test_VisitTable() throws Exception;

	public abstract void test_Sectiob_SubSection() throws Exception;

	public abstract void test_SubSection() throws Exception;

	public abstract void test_SubSubSection() throws Exception;

	public abstract void test_Paragraph() throws Exception;

	public abstract void test_Section_withText() throws Exception;

	public abstract void test_Section_withTwoText() throws Exception;

	public abstract void test_Table() throws Exception;

	public abstract void test_Table_noAlignement() throws Exception;

	public abstract void test_Table_alignement_centered() throws Exception;

	public abstract void test_Table_alignement_centered_one_columns()
			throws Exception;

	public abstract void test_Table_alignement_centered_one_columns_addOneHeaderMore()
			throws Exception;

	public abstract void test_Table_alignement_left() throws Exception;

	public abstract void test_Table_alignement_right() throws Exception;

	public abstract void test_that_empty_simple_table_returns_nothing()
			throws Exception;

	public abstract void test_that_simple_table_with_one_line_is_printed()
			throws Exception;

	public abstract void test_that_simple_table_with_two_lines_is_printed()
			throws Exception;

	public abstract void test_print_row_value_with_one_value_in_the_row()
			throws Exception;

	public abstract void test_print_row_value_with_two_valueq_in_the_row()
			throws Exception;

	public abstract void test_Table_alignement_sized() throws Exception;

}