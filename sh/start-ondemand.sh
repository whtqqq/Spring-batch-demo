#!/bin/sh
default_fvq_home=/home/ec2-user/FVQ
fvq_home=$default_fvq_home
lib=$fvq_home/lib
log=$fvq_home/logs/fvq-ondemand-job.log
target=$fvq_home/target/fvq.jar
job_runner=org.springframework.batch.core.launch.support.CommandLineJobRunner

# must provide three parameters
if [ $# -ne 3 ]; then
  echo "need 3 parameters(subsidiaryCd mcPlantCd batchDiv)."
  exit -1
fi

parameters="subsidiaryCd=$1 mcPlantCd=$2 batchDiv=$3"

java -cp $target:$lib/* $job_runner classpath:/batch-context.xml FVQ_OndemandJob $parameters >> $log 2>&1
