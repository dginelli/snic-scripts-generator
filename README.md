# snic-scripts-generator
This program allows the generation of the script files to run the experiments with SNIC (Swedish National Infrastructure for Computing).

## Getting Started

To generate the executable JAR file, follow these steps:

```
git clone https://github.com/dginelli/snic-scripts-generator.git
cd snic-scripts-generator
mvn clean package
```

## Command Line Usage

To generate the script files, you have to specify some specific values using the following options:

```
Usage: SNIC Scripts Generator [options]
  Options:
  * --account, -a
      It specifies the SNAC project ID formated as SNICYYYY-XX-ZZ.
  * --commandsFile, -c
      The file with the commands that have to be executed.
    --days, -d
      The days that should be reserved for the job.
    --help

    --hours, -h
      The hours that should be reserved for the job.
    --minutes, -m
      The minutes that should be reserved for the job.
  * --outputDirectory, -o
      The directory where to save the script files.
    --seconds, -s
      The seconds that should be reserved for the job.
```

The parameters marked with the symbol * are mandatory. Moreover, it is necessary to specify at least one of these parameters: `-d`, `-h`, `-m`, `-s`.

The value associated with the parameter `commandsFile` has to be the path of the file that contains the commands that have to be executed.
Every line of the file has to be associated with a single command.

## Example of use

To generate the script files associated with the commands contained in the `commands.txt` file, you have to run the following command:

```
java -jar snic-scripts-generator-0.0.1-SNAPSHOT-jar-with-dependencies.jar --outputDirectory <outputDirectoryPath> --commandsFile <commandsFile> --account <accountName> -h 1
```

The program will generate the folder `jobs` that contains all the script files that have to be executed, and the file `main.sh` that can be used to submit the jobs associated with the script files in SNIC.
