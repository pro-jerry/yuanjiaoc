#!/bin/bash

# today=$(date +%y%m%d)
# echo $today
# ls / -al >$today.log

# date >221124.log
# who >221124.log
# date >>221124.log

#var1=10
#var2=20
#var3=$(expr $var2 / $var1) #命令替换的方式
#echo The result is $var3
#var1=$((1 + 5))
#echo $var1
#var2=$(($var1 * 2))
#echo $var2

#var1=100
#var2=45
#var3=$(($var1 / $var2))
#echo The final result is $var3 #The final result is 2

#var1=10
#var2=30
#var3=$(($var1 + $var2))
#echo The answer is $var3
#exit 5

#if pwd; then
#  echo "It worked"
#fi
#testuser=admin01
#if grep $testuser /etc/passwd; then
#  echo "This is my first command"
#  echo "This is my second command"
#  echo "I can even put in other commands besides echo:"
#  ls -a /home/$testuser/.b*
#fi
#testuser=NoSuchUser
#if grep $testuser /etc/passwd; then
#  echo "The bash files for user $testuser are:"
#  ls -a /home/$testuser/.b*
#  echo
#else
#  echo "The user $testuser does not exist on this system."
#  echo
#fi
#testuser=NoSuchUser
#if grep $testuser /etc/passwd; then
#  echo "The user $testuser exists on this system."
#else
#  echo "The user $testuser does not exist on this system."
#  if ls -d /home/$testuser/; then
#    echo "However, $testuser has a directory."
#  fi
#fi

#testuser=admin01
#if grep $testuser /etc/passwd; then
#  echo "The user $testuser exists on this system."
#elif ls -d /home/$testuser; then
#  echo "The user $testuser does not exist on this system."
#  echo "However, $testuser has a directory."
#else
#  echo "The user $testuser does not exist on this system."
#  echo "And, $testuser does not have a directory."
#fi
#my_variable="Full"
#if test $my_variable; then
#  echo "The $my_variable expression returns a True"
#else
#  echo "The $my_variable expression returns a False"
#fi
#value1=10
#value2=11
#if [ $value1 -gt 5 ]; then
#  echo "The test value $value1 is greater than 5"
#fi
#if [ $value1 -eq $value2 ]; then
#  echo "The values are equal"
#else
#  echo "The values are different"
#fi

#val1=baseball
#val2=hockey
#if [ $val1 \> $val2 ]; then
#  echo "$val1 is greater than $val2"
#else
#  echo "$val1 is less than $val2"
#fi
