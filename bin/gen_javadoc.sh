#!/bin/bash
# ------------------------------------------------
# 一键自动生成所有子模块的 javadoc 文档
# ------------------------------------------------
# 示例：
#   ./bin/gen_javadoc.sh
# ------------------------------------------------

echo "Generate javadoc-jar for all modules ..."
mvn clean package -Dmaven.test.skip=true

items=`ls | grep 'exp-libs-'`
for item in $items
do
    echo "Generate javadoc for $item ..."
    srcFile=`ls ./$item/target | grep 'javadoc.jar$'`
    srcPath="./$item/target/$srcFile"

    if [ -f "$srcPath" ]; then
      snkPath="./$item/target/$item.zip"
      cp $srcPath $snkPath
      srcPath=$snkPath

      if [ -f "$srcPath" ]; then
        snkPath="./docs/javadocs/$item"
        if [ -d "$snkPath" ]; then
          rm -rf $snkPath
        fi
        mkdir -p $snkPath
        tar -zxvf $srcPath -C $snkPath
      fi
    fi
done
echo "Done ."
