#!/bin/sh

# replace default_fvq_home
sh_path=`echo $(cd $(dirname $0) && pwd)`
fvq_home=`dirname $sh_path`
esc_to="${fvq_home//\//\\/}"
esc_from="\/home\/ec2-user\/FVQ"
sed -i -e "s/$esc_from/$esc_to/g" $sh_path/fvq
sed -i -e "s/$esc_from/$esc_to/g" $sh_path/fvq-polling.sh
sed -i -e "s/$esc_from/$esc_to/g" $sh_path/start-ondemand.sh
sed -i -e "s/$esc_from/$esc_to/g" $sh_path/cron.conf

# register service
$sh_path/register-fvq-service.sh
