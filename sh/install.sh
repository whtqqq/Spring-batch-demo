#!/bin/sh

# replace default_fvq_home
fvq_home=`pwd`
esc_to="${fvq_home//\//\\/}"
esc_from="\/home\/ec2-user\/FVQ"
sed -i -e "s/$esc_from/$esc_to/g" ./sh/fvq
sed -i -e "s/$esc_from/$esc_to/g" ./sh/fvq-polling.sh
sed -i -e "s/$esc_from/$esc_to/g" ./sh/start-ondemand.sh
sed -i -e "s/$esc_from/$esc_to/g" ./sh/cron.conf

# register service
./sh/register-fvq-service.sh
