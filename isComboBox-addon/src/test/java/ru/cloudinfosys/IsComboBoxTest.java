package ru.cloudinfosys;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.cloudinfosys.isComboBox.IsComboBox;

// JUnit tests here
public class IsComboBoxTest {

	private IsComboBox isComboBox;

	@Before
	public void init() {
		isComboBox = new IsComboBox();
	}

	@Test
	public void thisAlwaysPasses() {
		Assert.assertNotNull(isComboBox);
	}
}
