# Lab_1_Java_Luka
The first laboratory work from the java course

10 Create a Printer class that will have the following fields: model: printer model; type: printer type (ink or laser); isColor: whether the printer is color (true - if so, false - if not); isDuplex: whether the printer has the possibility of double-sided printing (true - if so, false - if not); paperTrayCapacity: the maximum number of sheets in the paper tray; paperCount: The current number of sheets of paper in the tray.

The Printer class must have the following public methods: print(int pages): a method that prints the specified number of pages (implies subtraction from the number of sheets in the tray); loadPaper(int count): a method that adds the specified number of sheets of paper to the tray and provides a check for overflow of the tray, if the number of sheets after adding is greater than paperTrayCapacity, then paperCount should become equal to the maximum number of sheets.
