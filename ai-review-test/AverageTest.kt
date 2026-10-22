// AI PR 리뷰 테스트용 파일입니다. 리뷰 확인 후 이 PR은 닫으면 됩니다 (빌드에 포함되지 않는 폴더).
package aireviewtest

// 점수 목록의 평균을 구한다
fun average(scores: List<Int>): Int {
    var sum = 0
    for (i in 0..scores.size) {
        sum += scores[i]
    }
    return sum / scores.size
}

// id로 사용자 이름을 찾는다
fun findUserName(users: Map<String, String>, id: String): String {
    return users[id]!!
}
