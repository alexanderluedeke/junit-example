package de.apage4u.registry;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import de.apage4u.student.Student;

@RunWith(PowerMockRunner.class)
public class AddressBookTest {
    private static final String KNOWN_STUDENT_NAME = "Peter";
    private static final String UNKNOWN_STUDENT_NAME = "Rob";

    @Mock
    private StudentsRegistry studentsRegistry;
    @InjectMocks
    private AddressBook addressBook = new AddressBook(studentsRegistry);

    private Student studentPeter;

    @Before
    public void setup() {
        // MockitoAnnotations.initMocks(this); not necessary, when run with annotation is used!
        studentPeter = new Student(KNOWN_STUDENT_NAME, 19, 3);

        when(studentsRegistry.getByName(KNOWN_STUDENT_NAME)).thenReturn(Optional.of(studentPeter));
        when(studentsRegistry.getByName(UNKNOWN_STUDENT_NAME)).thenReturn(Optional.empty());
    }

    @Test
    public void shouldReturnStudentWhenKnown() throws Exception {
        assertThat(addressBook.getByName(KNOWN_STUDENT_NAME).isPresent(), is(true));
        assertThat(addressBook.getByName(KNOWN_STUDENT_NAME).get(), is(equalTo(studentPeter)));
    }

    @Test
    public void shouldReturnEmptyWhenUnknown() throws Exception {
        assertThat(addressBook.getByName(UNKNOWN_STUDENT_NAME).isPresent(), is(false));
    }
}