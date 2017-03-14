#!/bin/sh
# remove service
######################################## 
chkconfig --del fvq
cnt=`chkconfig --list  | grep fvq | wc -l`
if [ $cnt -gt 0 ]; then
  echo "faild to remove fvq service." 
  exit -1
fi

echo "Succeeded in removing faq service!" 
exit 0
