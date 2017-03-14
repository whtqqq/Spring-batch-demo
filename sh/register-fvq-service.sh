#!/bin/sh
# copy fvq to /etc/init.d/
######################################## 
cp -f ./fvq /etc/init.d
if [ ! -e /etc/init.d/fvq ]; then
  echo "failed to copy fvq to /etc/ini.d."
  exit -1
fi

# assign execute permission to fvq 
######################################## 
chmod a+x /etc/init.d/fvq
if [ $? -ne 0 ]; then
  echo "can't execute chmod for /etc/init.d/fvq." 
  exit -1
fi

# register service
######################################## 
chkconfig --add fvq
cnt=`chkconfig --list  | grep fvq | wc -l`
if [ $cnt -eq 0 ]; then
  echo "failed to register fvq service." 
  exit -1
fi

# start service
######################################## 
service fvq start
if [ $? -ne 0 ]; then
  echo "failed to start fvq." 
  exit -1
fi

echo "Succeeded in registering faq service!" 
exit 0
