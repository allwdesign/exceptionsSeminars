## The project contains functionality for save user data to the file.

### An application that will prompt the user for the following data, separated by a space:
<Surname> <Name> <Patronymic> <Date of birth> <Phone number> <Gender>

### Data formats:
- surname, name, patronymic - strings
- date of birth - format string dd.mm.yyyy
- phone number - unsigned integer without formatting
- gender - Latin character f or m.

### Example data: 
- Ivanov Ivan Ivanovich 06.08.1988 79881234567 m

### Data for testing App:
- Ivanov Petr Petrovich 09.09.1999 89123456789 m
- Kovolenko Karina Vladimirovna 08.12.1967 89645558868 f
- Ivanov Ivan Ivanovich 06.08.1988 79881234599 m
- WrongAmountOfDataException: Perl 2Ekl fk.09.9999 79999999999 m
- Wrong Surame: P/erl Ekl Ekdkkd 01.09.1999 79999999999 m
- Wrong Name: Perl 2Ekl Ekdkkd fk.09.9999 79999999999 m
- Wrong Patronymic: Perl Ekl Ekdk0_kd 07.09.1999 79999999999 m
- Wrong Birthday: Ivanov YY uu 00.33.5555 89999999999 m
- Wrong Birthday: Ivanov YY uu 00/33/5555 89999999999 m
- Wrong Phone: Ivanov Ivan Ivanovich 06.08.1988 798812345ka m
- Wrong Phone: Ivanov Ivan Ivanovich 06.08.1988 798812_34599 m
- Wrong Gender: Perl Ekl Ekdkkd 07.09.1999 79999999999 fm
- Wrong Gender: Perl Ekl Ekdkkd 07.09.1999 79999999999 0
