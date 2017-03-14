#!/bin/sh
# check fvq service
######################################## 
cnt=`chkconfig --list  | grep fvq | wc -l`
if [ $cnt -eq 0 ]; then
  echo "fvq service is not registered." 
  exit 0 
fi

# remove service
######################################## 
sudo service fvq stop
sudo chkconfig --del fvq
cnt=`chkconfig --list  | grep fvq | wc -l`
if [ $cnt -gt 0 ]; then
  echo "failed to remove fvq service." 
  exit -1
fi

# remove fvq file from /etc/init.d
######################################## 
sudo rm -f /etc/init.d/fvq

echo "Succeeded in removing faq service!" 
exit 0
