# Hugging Face Datasets overviews(Pytorch)

[https://www.youtube.com/watch?v=_BZearw7f0w&t=30s](https://www.youtube.com/watch?v=_BZearw7f0w&t=30s)

허깅퍼이스 데이터셋 라이브러리는 public dataset을 빠르게 다운로드하도록 API를 제공하는 라이브러리이다. 

### 다운로드 방법 & Preprocess a dataset

```python
from datasets import load_dataset

raw_datasets = load_dataset("glue", "mrpc")
raw_datasets
```

load_dataset 함수를 이용하면 파라미터로 넘겨진 identifier를 통해 directly 데이터셋을 다운로드하는 것이 가능하다.

위 코드에서는 GLUE 벤치마크에서 MRPC 데이터셋을 fetch 했다.

해당 데이터셋은 의역을 하는(?) sentence 짝을 가지고있다.

- paraphrases(의역)
    
    원래의 문장이나 구절을 쉽게 풀어내는 것
    
    의미를 유지하면서 다른 단어를 사용하여 무언가를 쓰거나 말하는 것.(문장을 더 간단하고, 더 짧고, 더 명확하게 만들기 위해 사용됨)
    
    사용하는 이유 : 원본 텍스트에 대한 이해/ 인용에 대한 대안..
    

```python
DatasetDict({
	train: Dataset({
		features: ['sentence1', 'sentence2', 'label', 'idx'],
		num_rows: 3668
	})
	validation: Dataset({
		features: ['sentence1', 'sentence2', 'label', 'idx'],
		num_rows: 408
	})
	test: Dataset({
		features: ['sentence1', 'sentence2', 'label', 'idx'],
		num_rows: 1725
	})
})
```

load_dataset 함수로 반환되는 object는 DatasetDict로, 데이터셋 split을 포함하고있는 dictionary집합이다.

각각의 split은 split의 이름을 index해서 접근할 수 있다.

```python
raw_datasets["train"]
```

```python
Dataset({
		features: ['sentence1', 'sentence2', 'label', 'idx'],
		num_rows: 3668
})
	
```

이 split은 Dataset 클래스의 instance이며, 'sentence1', 'sentence2', 'label', 'idx' 행과 3668개의 열을 갖고있다.

각각의 인덱스로 element에 접근할 수 있다.

```python
row_datasets["train"][6]
```

```python
{'idx' : 6,
 'label' : 0,
 'sentence1' : 'The Nasdaq blah blah',
 'sentence2' : 'The technique blah blah'}
```

Hugging Face Datasets Library의 좋은 점은 Apache Arrow를 이용하는 것이 디스크에 저장된다는 점이다. 

- Apache Arrow
    
    서로 다른 데이터 인프라가 서로 간의 데이터 공유를 위해 API를 이용할 떄 발생하는 문제점 중 하나는 직렬화와 역직렬화의 overhead가 너무 높다는 것이다(애플리케이션 성능👇🏻)
    
    Arrow는 언어, 플랫폼과 상관없이 메모리 상에서 컬럼 구조로 데이터를 정의하여, CPU와 GPU에서 메모리를 빠르게 읽고 쓸 수 있도록 한다.
    
    [https://realsalmon.tistory.com/21](https://realsalmon.tistory.com/21)
    
    ![스크린샷 2024-08-10 오후 2.39.49.png](Hugging%20Face%20Datasets%20overviews(Pytorch)%20c42fa8d285a549a4989edcea5bc46409/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2024-08-10_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_2.39.49.png)
    
    ![스크린샷 2024-08-10 오후 2.40.00.png](Hugging%20Face%20Datasets%20overviews(Pytorch)%20c42fa8d285a549a4989edcea5bc46409/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2024-08-10_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_2.40.00.png)
    

만약 우리가 사용하는 RAM의 용량보다 dataset이 더 크다고 한다해도, 우리가 요청하는 elements만이 메모리에 저장된다.

우리의 dataset slice를 접근하는 것은 하나의 element에 접근하는 것만큰 쉽다. 이후 결과는 각 키의 값의 사전 형태로 나온다.

![스크린샷 2024-08-10 오후 1.49.48.png](Hugging%20Face%20Datasets%20overviews(Pytorch)%20c42fa8d285a549a4989edcea5bc46409/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2024-08-10_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_1.49.48.png)

Dataset의 features속성은 우리에게 행에 대한 더 많은 정보를 준다. 

```python
raw_datasets["train"].features
```

```python
{'sentence1':Value(dtype="string", id = None),
 'sentence2':Value(dtype="string", id = None),
 'label' : ClassLabel(num_classes = 2, names=['not_equivalent', 'equivalent'], names_file=None, id=None),
 'idx' : Value(dtype= 'int32', id=None)}
```

이렇게 데이터 타입이나 머,,, 그런거 알려준다.

정수들과 라벨들 이름 사이의 상응하는 것을 알수있다.

여기서 0은 not_equivalent를, 1은 equivalent를 의미한다.

![스크린샷 2024-08-10 오후 2.01.00.png](Hugging%20Face%20Datasets%20overviews(Pytorch)%20c42fa8d285a549a4989edcea5bc46409/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2024-08-10_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_2.01.00.png)

우리 Dataset의 모든 elements를 미리 정제해 놓기 위해선 토큰화(tokenize)를 해야한다.

- 이 영상 참고하랜다,,
    
    Preprocessing sententce pairs
    
    [https://www.youtube.com/watch?v=0u3ioSwev3s](https://www.youtube.com/watch?v=0u3ioSwev3s)
    

tokenizer에 additional keyword argument와 함께 두 문장을 보내야한다. (너무 긴 input들은 잘라진다(truncate). )

우리는 직접적으로 dataset에 모든 split을 더하는 tokenize_function에 map method와 함께 모든 것을 넣는다.

```python
from transformers import AutoTokenizer

checkpoint = "bert-base-cased"
tokenizer = AutoTokenizer.from_pretrained(checkpoint)

def tokenize_function(example):
	return tokenizer(
		example["sentence1"], example["sentence2"], padding="max_length", truncation=True, max_length = 128
	)

tokenized_datasets = raw_datasets.map(tokenize_function)
print(tokenized_datasets.column_names)
```

function이 dictionary와 같은 형태를 return해주기 떄문에, map method는 새로운 행을 더하거나 이미 존재하는 행을 update하는 역할을 할것이다.

```python
from transfomers import AutoTokenizer

checkpoint = "bert-base-cased"
tokenizer = AutoTokenizer.from_pretrained(checkpoint)

def tokenize_function(examples):
	return tokenizer(
		examples["sentence1"], examples["sentence2"], padding="max_length",
			truncation=True, max_length=128
		)

tokenized_datasets = raw_datasets.map(tokenize_function, batched=True)
#batched=True!를 이용해 아래 기능 수행가능
```

preprocessing를 더 빠르게 하고, 토크나이저가 Rust기반이라는 것의 장점을 살려, 우리는 여러 element를 동시에 처리할수있다.(batched=True argument를 이용해..)

tokenizer는 first/second sentence의 list를 다룰 수 있기 때문에 tokenize_function은 이것을 위한 변경이 필요하지 않다. 또한 map method와 함꼐 멀티프로세싱을 사용할수잇다.

```python
tokenized_datasets = tokenized_datasets.remove_columns(["idx","sentence1","sentence2"])
tokenized_datasets = tokenized_datasets.rename_columns(["label","labels")
tokenized_datasets = tokenized_datasets.with_format("torch")
tokenized_datasets["train"]
```

```python
Dataset({
		features: ['attention_mask', 'input_ids', 'labels', 'token_type_ids'],
		num_rows: 3668
})
```