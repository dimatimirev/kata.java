����   A �
      java/lang/Object <init> ()V  java/util/Scanner	 
     java/lang/System in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V	 
    out Ljava/io/PrintStream;  #Введите выражение: 
      java/io/PrintStream println (Ljava/lang/String;)V
     ! nextLine ()Ljava/lang/String;
 # $ % & ' Main 	calculate &(Ljava/lang/String;)Ljava/lang/String;   ) * ' makeConcatWithConstants , java/lang/Exception	 
 . /  err
 + 1 2 ! 
getMessage  )
  5 6  close 8 "[^"]{1,10}"|\d+|[\+\-\*/]
 : ; < = > java/util/regex/Pattern compile -(Ljava/lang/String;)Ljava/util/regex/Pattern;
 @ A B C ! java/lang/String trim
 : E F G matcher 3(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
 I J K L M java/util/regex/Matcher find ()Z
 I O P ! group R :Неверное количество аргументов
 + T   V "[^"]{1,10}"
 @ X Y Z matches (Ljava/lang/String;)Z
 # \ ] Z isValidOperator _ !Некорректный ввод
 @ a b c length ()I
 @ e f g 	substring (II)Ljava/lang/String; i /
 @ k l m equals (Ljava/lang/Object;)Z o * q \d+ s @Второй аргумент должен быть числом
 u v w x y java/lang/Integer parseInt (Ljava/lang/String;)I { /Число должно быть от 1 до 10
 # } ~  repeatString '(Ljava/lang/String;I)Ljava/lang/String;
 # � � ' truncate
 # � �  divideString � BВторой аргумент должен быть строкой
 @ � � c hashCode � + � -  � * � 8(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
 # � � � subtractStrings � 1Неподдерживаемая операция �  
 @ � � � replace D(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String; � java/lang/StringBuilder
 � 
 � � � � append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 � � � ! toString  ) Code LineNumberTable LocalVariableTable this LMain; main ([Ljava/lang/String;)V result Ljava/lang/String; e Ljava/lang/Exception; args [Ljava/lang/String; scanner Ljava/util/Scanner; input StackMapTable � number I regex Ljava/util/regex/Matcher; tokens index str1 operator str2 
Exceptions i str n Ljava/lang/StringBuilder; 	newLength 
SourceFile 	Msin.java BootstrapMethods � "" � Ошибка:  �  � ... �
 � � � * � $java/lang/invoke/StringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; InnerClasses � %java/lang/invoke/MethodHandles$Lookup � java/lang/invoke/MethodHandles Lookup   #            �   /     *� �    �        �        � �   	 � �  �   �     A� Y� 	� L� � +� M,� "N� -� (  � � N� --� 0� 3  � +� 4�   ) , +  �   * 
     	  
     )  ,  -  <  @  �   4    � �  -  � �    A � �    6 � �   ) � �  �    � ,  �  @  + 	 & '  �  �  
  �7L+� 9*� ?� DM� @N6,� H� � -�,� NS���� � +YQ� S�-2:-2:-2:U� W� � [� � +Y^� S�� `d� d:h� j� n� j� Wp� W� � +Yr� S�� t6� 

� � +Yz� S�n� j� � |� �� � �� ��U� W� � +Y�� S�� `d� d::6	� ��   6      +      -   )�� j� 6	� �� j� 6		�   1                &� �  � ��� �� ��� +Y�� S�    �   r             $  2 ! 8 " B % G & L ' Q * c + m . | 0 � 1 � 2 � 4 � 5 � 6 � : � = � > � @ Bd Dq F| H �   \ 	 � 9 � �   � � �   � � �  w F �  r � �  o � �  G? � �  L: � �  Q5 � �  �   A �   @ @ I �  �   @ @ @	"� 	I @�  � 3 @
 �     + 
 ] Z  �   `     **�� j� *�� j� *n� j� *h� j� � �    �       N �       * � �   �    $@ 
 � �  �   <     *+�� ��    �       R �        � �      � �  
 ~   �   �      � �Y� �M>� ,*� �W����,� ��    �       V  W  X  W  Z �   *  
  � �      � �       � �    � �  �    � 
 ��  
 �   �   i     *� `l=� �� 	*� d�    �   
    ^  _ �         � �      � �    � �  �   
 � E @ 
 � '  �   Q     *� `(� *(� d� �  � *�    �       c �        � �   �    @ @  �    � �     �  � �  � �  � �  � �   
  � � � 