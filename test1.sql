use projectteam23;

LOAD DATA local INFILE 'C:\\Users\\Grad68\\Desktop\\NASDAQ_20130101.txt'
    
    INTO TABLE stockprice
    fields terminated by  ','
    lines terminated by '\n'
    IGNORE 1 LINES ;