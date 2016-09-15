mysql -u monty --password="Monty#186" << EOF
drop database magento;
create database magento;
EOF
gunzip < backupmagento.sql.gz | mysql -u monty --password="Monty#186" magento;